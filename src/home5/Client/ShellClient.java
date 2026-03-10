package home5.Client;

import home5.Client.Program.Shell;

public class ShellClient {
    public static void main(String[] args) {
        String input = "SHELLSORTROCKS";
        String[] a = input.split("");

        Shell.sort(a);

        System.out.println("Sorted Array:");
        for (String s : a) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}