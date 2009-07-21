 /*******************************************************************************
 * Copyright (c) 2007-2008 The Bioclipse Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * www.eclipse.org—epl-v10.html <http://www.eclipse.org/legal/epl-v10.html>
 *
 * Contributors:
 *     Jonathan Alvarsson
 *     Ola Spjuth
 *
 ******************************************************************************/

package net.bioclipse.biojava.business;

import java.util.List;

import org.eclipse.core.resources.IFile;

import net.bioclipse.core.PublishedClass;
import net.bioclipse.core.PublishedMethod;
import net.bioclipse.core.domain.IDNA;
import net.bioclipse.core.domain.IProtein;
import net.bioclipse.core.domain.IRNA;
import net.bioclipse.core.domain.ISequence;
import net.bioclipse.managers.business.IBioclipseManager;

/**
 * @author jonalv, ola
 */
@PublishedClass("Provides bioinformatics services through the BioJava project.")
public interface IBiojavaManager extends IBioclipseManager {

    /**
     * Sequence formats supported by the <code>BiojavaManager</code>.
     *
     * @author jonalv
     *
     */
    public enum SequenceFormat {
        FASTA,
        EMBL,
        GENBANK,
        UNIPROT;
    }

    /**
     * Returns a new <code>BiojavaDNA</code> sequence from the given
     * <code>String</code>.
     *
     * @param dnaString A DNA sequence to be converted.
     * @return A new <code>BiojavaDNA</code>.
     */
    @PublishedMethod(
        methodSummary = "Returns a new BiojavaDNA sequence from the given " +
        		        "String.",
        params = "String dnaString" )
    public IDNA DNAfromString(String dnaString);

    /**
     * Returns a new <code>BiojavaRNA</code> sequence from the given
     * <code>String</code>.
     *
     * @param rnaString An RNA sequence to be converted.
     * @return A new <code>BiojavaRNA</code>.
     */
    @PublishedMethod(
        methodSummary = "Returns a new BiojavaRNA sequence from the given " +
        		        "String.",
        params = "String rnaString" )
    public IRNA RNAfromString(String rnaString);

    /**
     * Returns a new <code>BiojavaProtein</code> sequence from the given
     * <code>String</code>.
     *
     * @param proteinString An amino acid sequence to be converted.
     * @return A new <code>BiojavaProtein</code>.
     */
    @PublishedMethod(
        methodSummary = "Returns a new BiojavaProtein sequence from the given " +
        		        "String.",
        params = "String proteinString" )
    public IProtein proteinFromString(String proteinString);

    /**
     * Returns the <code>IRNA</code> sequence equivalent of the given
     * <code>IDNA</code> sequence. The conversion process is called
     * <em>transcription</em>.
     *
     * @param dna the sequence to be converted
     * @return the result of the conversion
     */
    @PublishedMethod(
        methodSummary = "Returns the RNA sequence equivalent of the given DNA " +
        		        "sequence.",
        params = "IDNA dna" )
    public IRNA DNAtoRNA(IDNA dna);

    /**
     * Returns the <code>IProtein</code> sequence equivalent of the given
     * <code>IDNA</code> sequence. The conversion processes involved are
     * <em>transcription</em> followed by <em>translation</em>. The standard
     * genetic code is used.
     *
     * @param dna the sequence to be converted
     * @return the result of the conversion
     */
    @PublishedMethod(
        methodSummary = "Returns the protein sequence equivalent of the " +
        		        "given DNA sequence.",
        params = "IDNA dna" )
    public IProtein DNAtoProtein(IDNA dna);

    /**
     * Returns the <code>IDNA</code> sequence equivalent of the given
     * <code>IRNA</code> sequence. The conversion process is called
     * <em>reverse transcription</em>.
     *
     * @param rna the sequence to be converted
     * @return the result of the conversion
     */
    @PublishedMethod(
        methodSummary = "Returns the DNA sequence equivalent of the given " +
        		        "RNA sequence.",
        params = "IRNA rna" )
    public IDNA RNAtoDNA(IRNA rna);

    /**
     * Returns the <code>IProtein</code> sequence equivalent of the given
     * <code>IRNA</code> sequence. The conversion process is called
     * <em>translation</em>. The standard genetic code is used.
     *
     * @param rna the sequence to be converted
     * @return the result of the conversion
     */
    @PublishedMethod(
        methodSummary = "Returns the protein sequence equivalent of the " +
        		        "given RNA sequence.", 
        params = "IRNA rna" )
    public IProtein RNAtoProtein(IRNA rna);

    /**
     * Returns the <code>IDNA</code> sequence equivalent of the given
     * <code>IProtein</code> sequence. The conversion processes involved are
     * <em>reverse translation</em> and <em>reverse transcription</em>. The
     * standard genetic code is used.
     *
     * Because the genetic code is redundant, no guarantee can be made about
     * round-tripping an <code>IDNA</code> sequence to <code>IProtein</code>
     * and back.
     *
     * @param protein the sequence to be converted
     * @return the result of the conversion
     */
    @PublishedMethod(
        methodSummary = "Returns the DNA sequence equivalent of the given " +
        		        "protein sequence.",
        params = "IProtein protein" )
    public IDNA ProteinToDNA(IProtein protein);

    /**
     * Returns the <code>IRNA</code> sequence equivalent of the given
     * <code>IProtein</code> sequence. The conversion process is called
     * <em>reverse translation</em>. The standard genetic code is used.
     *
     * Because the genetic code is redundant, no guarantee can be made about
     * round-tripping an <code>IRNA</code> sequence to <code>IProtein</code>
     * and back.
     *
     * @param protein the sequence to be converted
     * @return the result of the conversion
     */
    @PublishedMethod(
        methodSummary = "Returns the RNA sequence equivalent of the given " +
        		        "protein sequence.",
        params = "IProtein protein" )
    public IRNA ProteinToRNA(IProtein protein);

    /**
     * @param string
     * @return
     */
    @PublishedMethod( 
        methodSummary = "Loads sequences from file at path",
        params = "String path" ) 
    public List<ISequence> sequencesFromFile( String path );
    
    public List<ISequence> sequencesFromFile( IFile file );
}
