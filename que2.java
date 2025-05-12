import java.util.LinkedList;

class BrowserHistory {
    private LinkedList<String> history;
    private int currentIndex;

    public BrowserHistory(String homepage) {
        history = new LinkedList<>();
        history.add(homepage);
        currentIndex = 0;
    }

    public void visit(String url) {
        while (history.size() > currentIndex + 1) {
            history.removeLast();
        }
        history.add(url);
        currentIndex++;
    }

    public String back(int steps) {
        currentIndex = Math.max(currentIndex - steps, 0);
        return history.get(currentIndex);
    }

    public String forward(int steps) {
        currentIndex = Math.min(currentIndex + steps, history.size() - 1);
        return history.get(currentIndex);
    }
}

public class que2 {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");

        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.forward(1));
        System.out.println(browserHistory.back(2));
    }
}
