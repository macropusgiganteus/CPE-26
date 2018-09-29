/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw.pkg1.data;


import java.util.Scanner;
public class HW1DATA {
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.print("input : ");
        int N = input.nextInt();
        for(int i=N;i>0;i/=2){
            for(int j=i;j>0;j--){
                System.out.println("Ahh!");
            }
            System.out.println("Ohh!");
        }
    }
}


