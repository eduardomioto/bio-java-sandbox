package br.com.mioto.med.bio.tutorial.structure;

import org.biojava.nbio.structure.Structure;
import org.biojava.nbio.structure.StructureIO;
import org.biojava.nbio.structure.StructureTools;

public class BasicAsymmetricUnit {

	public static void main(String[] args){

		try {
			Structure structure = StructureIO.getBiologicalAssembly("1GAV");
			// and let's print out how many atoms are in this structure
			System.out.println(StructureTools.getNrAtoms(structure));
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
