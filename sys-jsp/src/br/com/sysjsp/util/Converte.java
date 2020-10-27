package br.com.sysjsp.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Converte {
	
	/*Converte a entrada de fluxo de dados da imagem para um array de byte[]*/
	public byte[] converteStreamParaByte(InputStream imagem) {
		try {
			
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			int reads;
			reads = imagem.read();

			/* enquanto tiver dados */
			while (reads != -1) {
				byteArrayOutputStream.write(reads);
				reads = imagem.read();
			}

			return byteArrayOutputStream.toByteArray();/* retorna um array de bytes */

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
