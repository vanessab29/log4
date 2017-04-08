package application.controleur.commandes;

import application.controleur.ControleurPerspective;
import application.modele.PerspectiveModele;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Khoi on 2017-04-07.
 */
public class GestionnaireDeCommande {

    private static GestionnaireDeCommande uniqueInstance = new GestionnaireDeCommande();

    private GestionnaireDeCommande(){}

    public static GestionnaireDeCommande getInstance(){
        return uniqueInstance;
    }

    private Stack<Commande> commandesFaitesVue1 = new Stack<Commande>();
    private Stack<Commande> commandesAnnuleesVue1 = new Stack<Commande>();

    private Stack<Commande> commandesFaitesVue2 = new Stack<Commande>();
    private Stack<Commande> commandesAnnuleesVue2 = new Stack<Commande>();

    public void execute(Commande commande, int vue) {
        if(vue==1) {
            commande.execute();
            commandesFaitesVue1.push(commande);
        }
        else if(vue==2){
            commande.execute();
            commandesFaitesVue2.push(commande);
        }
    }

    public boolean IsEmptyCommandesFaitesVue1() {
        return commandesFaitesVue1.empty();
    }

    /**
     *
     */
    public boolean isEmptyCommandesAnnuleesVue1() {
        return commandesAnnuleesVue1.empty();
    }

    public boolean IsEmptyCommandesFaitesVue2() {
        return commandesFaitesVue2.empty();
    }

    /**
     *
     */
    public boolean isEmptyCommandesAnnuleesVue2() {
        return commandesAnnuleesVue2.empty();
    }


    public void defaire1() {
        if(!IsEmptyCommandesFaitesVue1()) {
            Commande derniereCommande = commandesFaitesVue1.pop();
            derniereCommande.unexecute();
            commandesAnnuleesVue1.push(derniereCommande);
        }
    }

    public void refaire1() {
        if(!isEmptyCommandesAnnuleesVue1()) {
            Commande derniereCommande = commandesAnnuleesVue1.pop();
            derniereCommande.execute();
            commandesFaitesVue1.push(derniereCommande);
        }
    }


    public void defaire2() {
        if(!IsEmptyCommandesFaitesVue2()) {
            Commande derniereCommande = commandesFaitesVue2.pop();
            derniereCommande.unexecute();
            commandesAnnuleesVue2.push(derniereCommande);
        }
    }

    public void refaire2() {
        if(!isEmptyCommandesAnnuleesVue1()) {
            Commande derniereCommande = commandesAnnuleesVue2.pop();
            derniereCommande.execute();
            commandesFaitesVue2.push(derniereCommande);
        }
    }

    public void execute(Commande commande) {
        commande.execute();
        System.out.println("COMMADE EXECUTE");
        commandesFaitesVue1.push(commande);
    }
//
//    ArrayList<PerspectiveModele> historyList;
//
//    public void add(PerspectiveModele perspectiveModele){
//        historyList.add(perspectiveModele);
//    }
//
//    public PerspectiveModele get(int index){
//        return historyList.get(index);
//    }

}
