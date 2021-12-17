/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Random;

/**
 *
 * @author Supun Madushanka
 */
public class CodeGEN {
    public final String charset="123456789zxcvbnmasdfghjklqwertyuiop";
    
    public String getCode(){
        Random random=new Random(System.currentTimeMillis());
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<20;i++){
            int pos=random.nextInt(charset.length());
            sb.append(charset.charAt(pos));
        
        }
        
        
        return sb.toString();
    
    }
}
