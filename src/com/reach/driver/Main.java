package com.reach.driver;

/*
 * Author: Orel Gershonovich, Kobi Hadad and Moisey Moshe Bakshi
 * A final project in Software Engineering course at HIT
 * Realse: 6/7/20
 */

import com.reach.model.WriterReader;
import com.reach.view.*;

public class Main {
    public static void main(String[] args) {
        WriterReader initial = new WriterReader();
        initial.loadAll();
        initial.saveAll();
        View v1 = new MainPanel();
        v1.showScreen();
        initial.saveAll();
    }
}