/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reversectf;

/**
 *
 * @author DELL 5577
 */
public class ReverseCtf {
    public static void main(String[] args) {
        String encoded = "Co_l3nnnnn_b@n_saP_d@nh_ba1_du0c_Spid3r_Rui_!";
        System.out.println("Flag: " + reverseFlag(encoded));
    }

    public static String reverseFlag(String encoded) {
        // Bước 1: Dịch ngược first()
        int[] adj = {-11, 34, -28, -8, -57, -8, 2, 3, 5, -17, -13, -18, -53, -5, 0, 3, -19, -16, -12, -6,
                     -48, 10, 7, -19, -4, -1, -67, -19, -15, 9, -47, -14, -8, -27, 3, -19, 3, -59, 5, -30,
                     8, 33, 22, -6, -50};
        StringBuilder decodedFirst = new StringBuilder();
        for (int i = 0; i < encoded.length(); i++) {
            decodedFirst.append((char) (encoded.charAt(i) - adj[i]));
        }

        // Bước 2: Dịch ngược second()
        String temp = decodedFirst.toString();
        int sIndex1 = temp.indexOf('S');
        int sIndex2 = temp.indexOf('S', sIndex1 + 1);
        
        String a = temp.substring(0, sIndex1 + 1);
        String b = temp.substring(sIndex1 + 1, sIndex2 + 1);
        String c = temp.substring(sIndex2 + 1);

        String decodedSecond = a + b + c;

        // Bước 3: Dịch ngược third()
        StringBuilder decodedThird = new StringBuilder();
        for (int i = 0; i < decodedSecond.length(); i++) {
            char ch = decodedSecond.charAt(i);
            if (i % 3 == 0) {
                ch -= (i / 3);
            } else if (i % 3 == 2) {
                ch -= ((i - 2) / 3);
            }
            decodedThird.append(ch);
        }

        // Bước 4: Dịch ngược fourth()
        String decodedFourth = decodedThird.substring(decodedThird.length() - 19) +
                               decodedThird.substring(0, decodedThird.length() - 19);

        return decodedFourth;
    }
}

