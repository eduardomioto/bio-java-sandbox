package br.com.mioto.med.bio.tutorial.structure;

import org.biojava.nbio.structure.Structure;
import org.biojava.nbio.structure.StructureIO;
import org.biojava.nbio.structure.align.gui.jmol.StructureAlignmentJmol;

/**
 * The Class BiologicalAssembly.
 */
public class BiologicalAssembly {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){

		try {
			Structure asymUnit = StructureIO.getStructure("1hho");

			showStructure(asymUnit);

			Structure bioAssembly = StructureIO.getBiologicalAssembly("1hho");

			showStructure(bioAssembly);

		} catch (Exception e){
			e.printStackTrace();
		}

	}

	/**
	 * Show structure.
	 *
	 * @param structure the structure
	 */
	public static void showStructure(Structure structure){

		StructureAlignmentJmol jmolPanel = new StructureAlignmentJmol();

		jmolPanel.setStructure(structure);

		// send some commands to Jmol
		jmolPanel.evalString("select * ; color chain;");            
		jmolPanel.evalString("select *; spacefill off; wireframe off; cartoon on;  ");
		jmolPanel.evalString("select ligands; cartoon off; wireframe 0.3; spacefill 0.5; color cpk;");

	}
}
