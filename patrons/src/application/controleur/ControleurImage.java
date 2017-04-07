package application.controleur;

import application.modele.ImageModele;
import application.vues.VueThumbnail;
import framework.Controleur;
import framework.Modele;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.EventListener;


public class ControleurImage extends Controleur<ImageModele, VueThumbnail> implements EventListener, MouseListener {

	public ControleurImage(ImageModele imageModele, VueThumbnail vue){
		modele(imageModele);
		vue(vue);
	}

	public Image ouvrirFichier(File fichierImage){
		return modele.ouvrirFichier(fichierImage);
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("Image");
		System.out.println("Controller: acting on Model");
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent me) {
		System.out.println("Image released");
		System.out.println("Controller: acting on Model");
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}


	public void addModel(ImageModele imageModele) {
		// TODO Auto-generated method stub
		
	}

//	public void choisirFichierAOuvrir() {
//		JFileChooser fc = new JFileChooser();
//
//		FileFilter imageFilter = new FileNameExtensionFilter(
//				"Fichiers image", ImageIO.getReaderFileSuffixes());
//
//		fc.setFileFilter(imageFilter);
//		fc.setCurrentDirectory(new File("."));
//		fc.setDialogTitle("Choisir une Image");
//
//		int response = fc.showOpenDialog(new JFrame());
//
//		if (response == JFileChooser.APPROVE_OPTION) {
//			//		String filePath = fc.getCurrentDirectory().toString() + "/" + fc.getSelectedFile().getName();
//			File fichierImage = fc.getSelectedFile();
//			modele.ouvrirFichier(fichierImage);
//		} else if (response == JFileChooser.CANCEL_OPTION){
//			System.out.println("L'opération a été annulée.");
//		}

//		setChanged();
//		notifyObservers();
	//}

}
