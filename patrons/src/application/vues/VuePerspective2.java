package application.vues;

import application.controleur.ControleurImage;
import application.controleur.ControleurPerspective;
import application.modele.ImageModele;
import application.modele.PerspectiveModele;
import framework.Vue;

import java.awt.*;
import java.util.Observable;

public class VuePerspective2 extends Vue<PerspectiveModele, ControleurPerspective> {


    public VuePerspective2(PerspectiveModele perspectiveModele, ControleurPerspective controleurPerspective){
        modele(perspectiveModele);
        controleur(controleurPerspective);
    }

    @Override
    protected void render() {

    }


    @Override
    public void paint(final Graphics g) {
        super.paintComponent(g);
        try {
            g.drawImage(modele.getImage(), 0, 0, null);
        } catch (final NullPointerException e) {
        }
    }


    @Override
    public void update(final Observable model, final Object value) {

        repaint();
    }
}
