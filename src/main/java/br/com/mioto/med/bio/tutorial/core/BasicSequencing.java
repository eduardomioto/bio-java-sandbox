/*
 * 
 */
package br.com.mioto.med.bio.tutorial.core;

import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.RNASequence;
import org.biojava.nbio.core.sequence.compound.AmbiguityDNACompoundSet;

/**
 * The Class BasicSequencing.
 */
public class BasicSequencing {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		try {
			createDNASequence();
			createRNASequence(); 
			createProteinSequence(); 
			createDNAAmbiguity();
		} catch (CompoundNotFoundException e) {
			e.printStackTrace();
		} 
		 
	}

	/**
	 * Creates the DNA ambiguity.
	 * In particular when dealing with nucleotide sequences, sometimes the exact nucleotides are not known. 
	 * BioJava supports standard conventions for dealing with such ambiguity. For example to represent the nucleotides 
	 * "A or T" often "W" is getting used. The expected set of compounds in a sequence by default is strict, however
	 * it takes only one line of code to switch to supporting ambiguity codes.
	 *
	 * @throws CompoundNotFoundException the compound not found exception
	 */
	private static void createDNAAmbiguity() throws CompoundNotFoundException {
		System.out.println("createDNAAmbiguity");
		AmbiguityDNACompoundSet ambiguityDNACompoundSet = AmbiguityDNACompoundSet.getDNACompoundSet();
		DNASequence dna = new DNASequence("WWW",ambiguityDNACompoundSet);
		System.out.println("DNASequence >> " + dna);
	}

	/**
	 * Creates the protein sequence.
	 *
	 * @throws CompoundNotFoundException the compound not found exception
	 */
	private static void createProteinSequence() throws CompoundNotFoundException {
		System.out.println("createProteinSequence");
		ProteinSequence seq = new ProteinSequence("MSTNPKPQRKTKRNTNRRPQDVKFPGG");
		System.out.println("ProteinSequence >> " + seq);
	}

	/**
	 * Creates the RNA sequence.
	 *
	 * @throws CompoundNotFoundException the compound not found exception
	 */
	private static void createRNASequence() throws CompoundNotFoundException {
		System.out.println("createRNASequence");
		RNASequence seq = new RNASequence("GUAC");
		System.out.println("RNASequence >> " + seq);
	}

	/**
	 * Creates the DNA sequence.
	 * In addition to the basic DNA sequence class there are specialized classes that extend DNASequence: ChromosomeSequence,
	 * GeneSequence, IntronSequence, ExonSequence, TranscriptSequence
	 *
	 * @throws CompoundNotFoundException the compound not found exception
	 */
	private static void createDNASequence() throws CompoundNotFoundException {
		System.out.println("createDNASequence");
		DNASequence seq = new DNASequence("GTAC");
		System.out.println("DNASequence >> " + seq);
	}
}
