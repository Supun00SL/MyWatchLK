/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.ArrayList;

/**
 *
 * @author Supun Madushanka
 */
public class LastSeen {

    private ArrayList<String> cr1;

    public LastSeen() {
        cr1 = new ArrayList();
    }

    public ArrayList<String> getLastSeen() {
        return cr1;
    }

    public void AddToLastSeen(String id) {
        if (cr1.isEmpty()) {
            cr1.add(id);
        }
        if(cr1.size()==3){
        cr1.remove(1);
        }
        if (!cr1.contains(id)) {
            cr1.add(id);
        }
        System.out.println("cr1 :"+cr1);

    }

}
