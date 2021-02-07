public class 整数转罗马数字 {
}

class Solution15 {
    public String intToRoman(int num) {
        if(num < 1 || num > 3999){
            return null;
        }
        int[] arr = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int mark = 0;
        String re = "";
        while(num > 0){
            if(num >= arr[mark]){
                num-=arr[mark];
                re+=str[mark];
            } else{
                mark++;
            }
        }
        return re;
    }
}