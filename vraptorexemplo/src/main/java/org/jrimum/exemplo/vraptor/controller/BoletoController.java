package org.jrimum.exemplo.vraptor.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.exemplo.vraptor.boleto.BoletoFactory;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.interceptor.download.Download;
import br.com.caelum.vraptor.interceptor.download.InputStreamDownload;

/**
 * Controlador para geração de boleto
 * 
 * @author Rômulo Augusto
 */
@Resource
public class BoletoController {

	private BoletoFactory boletoFactory;
	
	public BoletoController(BoletoFactory boletoFactory) {
		this.boletoFactory = boletoFactory;
	}
	
	/**
	 * Realiza o download de um boleto com dados padrão.
	 * @return
	 */
	public Download download() {
		
		Boleto boleto = boletoFactory.createDefaultBoleto();
		byte[] pdfAsBytes = new BoletoViewer(boleto).getPdfAsByteArray();

		InputStream inputStream = new ByteArrayInputStream(pdfAsBytes);
		Download download = new InputStreamDownload(inputStream, "application/pdf", "boleto.pdf", true, pdfAsBytes.length);
		
		return download;
	}
}
