public class que1 {
    public static void main(String[] args) {
        int arr[][] =
                {
                        {-9, -9, -9,  1, 1, 1},
                        { 0, -9,  0,  4, 3, 2},
                        {-9, -9, -9,  1, 2, 3},
                        { 0,  0,  8,  6, 6, 0},
                        { 0,  0,  0, -2, 0, 0},
                        { 0,  0,  1,  2, 4, 0}
                };

        int ans=0;
        int sum=0;

        for(int i=0;i<(6-2);i++){
            for(int j=0;j<(6-2);j++){
                int number1=arr[i][j];
                int number2=arr[i][j+1];
                int number3=arr[i][j+2];
                int number4=arr[i+1][j+1];
                int number5=arr[i+2][j];
                int number6=arr[i+2][j+1];
                int number7=arr[i+2][j+2];
            sum=number1+number2+number3+number4+number5+number6+number7;
                if(sum>ans){
                    ans=sum;
                }
            }
        }

        System.out.println(ans);
    }
}

