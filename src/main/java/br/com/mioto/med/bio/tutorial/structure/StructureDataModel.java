package br.com.mioto.med.bio.tutorial.structure;

import java.io.IOException;
import java.util.List;

import org.biojava.nbio.structure.Atom;
import org.biojava.nbio.structure.Chain;
import org.biojava.nbio.structure.Group;
import org.biojava.nbio.structure.Structure;
import org.biojava.nbio.structure.StructureException;
import org.biojava.nbio.structure.StructureIO;

/**
 * The Class StructureDataModel.
 */
public class StructureDataModel {

	/**
	 * The main method.
	 * Structure 
	 *	   |
	 *	   Model(s)
	 *	        |
	 *	        Chain(s)
	 *	            |
	 *	             Group(s) -> Chemical Component Definition
	 *	                 |
	 *	                 Atom(s)
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Structure structure;
		try {
			structure = StructureIO.getStructure("4hhb");
			List<Chain> chains = structure.getChains();
			System.out.println(" # chains: " + chains.size());

			for (Chain c : chains) {
				System.out.println("   Chain: " + c.getChainID() + " # groups with atoms: " + c.getAtomGroups().size());

				for (Group g: c.getAtomGroups()){
					if ( g.getPDBName().equalsIgnoreCase("HEM")) {

						System.out.println("   " + g);
						for (Atom a: g.getAtoms()) {
							System.out.println("    " + a);
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (StructureException e) {
			e.printStackTrace();
		}         
	}
}
