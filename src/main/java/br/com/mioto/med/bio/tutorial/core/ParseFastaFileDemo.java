package br.com.mioto.med.bio.tutorial.core;

import java.io.File;
import java.io.InputStream;
import java.util.LinkedHashMap;

import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.compound.AminoAcidCompound;
import org.biojava.nbio.core.sequence.compound.AminoAcidCompoundSet;
import org.biojava.nbio.core.sequence.io.FastaReader;
import org.biojava.nbio.core.sequence.io.GenericFastaHeaderParser;
import org.biojava.nbio.core.sequence.io.ProteinSequenceCreator;
import org.biojava.nbio.core.util.InputStreamProvider;

public class ParseFastaFileDemo {

	/** Download a large file, e.g. ftp://ftp.uniprot.org/pub/databases/uniprot/current_release/knowledgebase/complete/uniprot_trembl.fasta.gz
	 * and pass in path to local location of file
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		if ( args.length < 1) {
			System.err.println("First argument needs to be path to fasta file");
			return;
		}

		File f = new File(args[0]);

		if ( ! f.exists()) {
			System.err.println("File does not exist " + args[0]);
			return;
		}

		try {

			// automatically uncompresses files using InputStreamProvider
			InputStreamProvider isp = new InputStreamProvider();

			InputStream inStream = isp.getInputStream(f);

			FastaReader<ProteinSequence, AminoAcidCompound> fastaReader = new FastaReader<ProteinSequence, AminoAcidCompound>(
					inStream,
					new GenericFastaHeaderParser<ProteinSequence, AminoAcidCompound>(),
					new ProteinSequenceCreator(AminoAcidCompoundSet.getAminoAcidCompoundSet()));

			LinkedHashMap<String, ProteinSequence> b;


			int nrSeq = 0;

			while ((b = fastaReader.process(10)) != null) {
				for (String key : b.keySet()) {
					nrSeq++;
					System.out.println(nrSeq + " : " + key + " " + b.get(key));
				}

			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
}
