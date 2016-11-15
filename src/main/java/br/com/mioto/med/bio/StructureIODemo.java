package br.com.mioto.med.bio;

import org.biojava.nbio.structure.Structure;
import org.biojava.nbio.structure.StructureIO;
import org.biojava.nbio.structure.StructureTools;

public class StructureIODemo {

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
