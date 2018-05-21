package com.company.ServerClientSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Gradebook_Client {
    public static void main(String[] sir) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Adresa serverului si portul :");
        String adresa = sc.next(); int port = sc.nextInt();
        sc.nextLine();
        Socket cs = null;
        try { cs = new Socket(adresa,port); }
        catch(Exception e) {
            System.out.println("Conexiune esuata");
            System.exit(1);
        }
        DataInputStream dis; DataOutputStream dos;
        dis = new DataInputStream(cs.getInputStream());
        dos = new DataOutputStream(cs.getOutputStream());
        String linie;
        for( ; ; ) {
            System.out.print("Mesaj de trimis : \t");
            linie = sc.nextLine(); dos.writeUTF(linie);
            linie = linie.trim();
            if( linie.equals("STOP") ) break;
            linie = dis.readUTF();
            System.out.println("Mesaj receptionat :\t" + linie);
        }
        System.out.println("GATA");
        cs.close(); dis.close(); dos.close();
    }
}
