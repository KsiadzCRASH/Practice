package deep.one.img;

import deep.one.types.ImgData;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

public class FileToImgData {

	public static ImgData readImage(BufferedImage image){
		DataBufferByte dataBufferByte = (DataBufferByte) image.getRaster().getDataBuffer();
		return new ImgData(image.getWidth(), image.getHeight(), dataBufferByte.getData());
	}


}
