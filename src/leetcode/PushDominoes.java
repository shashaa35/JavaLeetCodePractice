package leetcode;

//https://leetcode.com/problems/push-dominoes/
public class PushDominoes {
    public static void main(String[] args) {
        PushDominoes obj = new PushDominoes();
        System.out.println(obj.pushDominoes(new String("RR.L")));
        System.out.println(obj.pushDominoes(new String(".L.R.")));
        System.out.println(obj.pushDominoes(new String(".L.R...LR..L..")));
    }

    public String pushDominoes(String dominoes) {
        int change = 1;
        char[] s = dominoes.toCharArray();
        char[] temp = new char[s.length];
//        System.out.println(s);
        while (change>0) {
            change = 0;
            temp = s.clone();
            //for R dominoes
            for (int i = 0; i < s.length-1; i++) {
                if (s[i] == 'R' && s[i+1] == '.') {
                    if (i+2 == s.length || s[i+2] != 'L') {
                        //XXXR. , XXXR.L , XXXR.R , XXXR.....
                        temp[i+1] = 'R';
                        change++;
                        i++;
                    }
                }
            }
//            System.out.println(s);
            // for L dominos
            for (int i = s.length-1; i > 0; i--) {
                if (s[i] == 'L' && s[i-1] == '.') {
                    if (i-2 == -1 || s[i-2] != 'R') {
                        //.L, XXXR.LXXX, XXXL.LXXX, XXX.LXXX
                        temp[i-1] = 'L';
                        change++;
                        i--;
                    }
                }
            }
            s = temp.clone();
//            System.out.println(s);
        }
        return String.valueOf(s);
    }
}
