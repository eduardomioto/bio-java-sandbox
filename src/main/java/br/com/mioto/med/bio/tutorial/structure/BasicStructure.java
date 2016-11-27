package br.com.mioto.med.bio.tutorial.structure;

import org.biojava.nbio.structure.Structure;
import org.biojava.nbio.structure.StructureIO;
import org.biojava.nbio.structure.StructureTools;

/**
 * The Class BasicStructure.
 */
public class BasicStructure {

	/**
	 * The main method.
	 * BioJava automatically downloads the PDB file for hemoglobin 4HHB and copies it into a
	 * temporary location. Then the PDB file parser loads the data into a Structure object, that
	 * provides access to the content in the file. (If you call this a second time, BioJava will
	 * automatically re-use the local file.)
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
        try {
                Structure structure = StructureIO.getStructure("4HHB");
                // and let's print out how many atoms are in this structure
                System.out.println(StructureTools.getNrAtoms(structure));
            } catch (Exception e){
                e.printStackTrace();
        }
    }   
}
