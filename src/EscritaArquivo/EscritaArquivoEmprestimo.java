/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EscritaArquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Rafael
 */
public class EscritaArquivoEmprestimo {
    private Date data;
    
    public EscritaArquivoEmprestimo(String saleFile,String id_livro, String rg, String datate) throws ParseException{
    File arquivo = new File(saleFile);
    data = new Date();
        try  {
            
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            data = formatador.parse(datate);
            BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));
            bw.newLine();
            bw.write(id_livro + "," + rg + "," + formatador.format(data));
            bw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (FileReader fr = new FileReader(arquivo)) {
            BufferedReader br = new BufferedReader(fr);
            String content;
            while ((content = br.readLine()) != null) {
                System.out.println(content);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
