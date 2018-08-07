import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main{
    public static char[] color = new char[5];
    public static int[] number = new int[5];
    public static int answer = 0;
 
    public static void calScore() {
        int colormatch = 1;
        int numbermatch = 1;
        int next = 0;
        int i = 0;
        boolean continuous = false;
        int max = 0;
 
        for (; i < 5; i++) {
            next = i + 1;
            if (next == 5) {
                break;
            } else {
                if (color[i] == color[i + 1]) {
                    colormatch++;
                }
            }
        }
 
        max = number[0];
        int[] matchedNumber = new int[10];
        for (i = 0; i < 5; i++) {
            matchedNumber[number[i]]++;
            next = i + 1;
            if (next == 5) {
                break;
            } else {
                if (max < number[next]) {
                    max = number[next];
                }
            }
        }
         
        for (i = 1; i < 10; i++) {
            next = i + 4;
            if (next == 10) {
                break;
            } else {
                if ((matchedNumber[i] == 1) && (matchedNumber[i + 1] == 1) && (matchedNumber[i + 2] == 1)
                        && (matchedNumber[i + 3] == 1) && (matchedNumber[next] == 1)) {
                    continuous = true;
                }
            }
        }
 
        int twice = 0;
        int third = 0;
 
        if (colormatch == 5) {
            if (continuous == true) {
                answer = 900 + max;
            } else {
                answer = 600 + max;
            }
        }
 
        else {
            if (continuous == true) {
                answer = 500 + max;
            } else {
                for (i = 1; i < 10; i++) {
                    switch (matchedNumber[i]) {
                    case 1:
                        continue;
                    case 2:
                        if (twice > 0) {
                            if (i > twice) {
                                answer = 300 + (i * 10) + twice;
                                break;
                            } else if (i <= twice) {
                                answer = 300 + (twice * 10) + i;
                                break;
                            }
                        } else {
                            twice = i;
                            answer = 200 + i;
 
                            if (third > 0) {
                                answer = 700 + (third * 10) + twice;
                                break;
                            }
                            else {
                                break;
                            }
                        }
 
                    case 3:
                        third = i;
                        if (twice > 0) {
                            answer = 700 + (third * 10) + twice;
                            break;
                        } else {
                            answer = 400 + i;
                            break;
                        }
 
                    case 4:
                        answer = 800 + i;
                        break;
                    }
                }
                if (answer == 0) {
                    answer = 100 + max;
                }
            }
        }
 
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp;
        String[] temp2;
 
        for (int i = 0; i < 5; i++) {
            temp = br.readLine();
            temp2 = temp.split(" ");
 
            color[i] = temp2[0].charAt(0);
            number[i] = Integer.parseInt(temp2[1]);
        }
        calScore();
        System.out.print(answer);
    }
}
