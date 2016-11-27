package br.com.mioto.med.bio.tutorial.structure;

import org.biojava.nbio.structure.Structure;
import org.biojava.nbio.structure.StructureIO;
import org.biojava.nbio.structure.align.gui.jmol.StructureAlignmentJmol;

/**
 * The Class Basic3DView.
 */
public class Basic3DView {

	/**
	 * The main method.
	 * The StructureAlignmentJmol class provides a wrapper for the 
	 * Jmol viewer and provides a bridge to BioJava, so Structure objects
	 * can be sent to Jmol for visualisation.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		try {

			Structure struc = StructureIO.getStructure("4hhb");

			StructureAlignmentJmol jmolPanel = new StructureAlignmentJmol();

			jmolPanel.setStructure(struc);

			// send some commands to Jmol
			jmolPanel.evalString("select * ; color chain;");            
			jmolPanel.evalString("select *; spacefill off; wireframe off; cartoon on;  ");
			jmolPanel.evalString("select ligands; cartoon off; wireframe 0.3; spacefill 0.5; color cpk;");

		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
