package org.module.commons.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import org.module.commons.base.BaseLog;
import org.module.commons.util.qr.BufferedImageLuminanceSource;
import org.module.commons.util.qr.MatrixToImageWriter;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

/**
 * 
 * 类: QRCodeUtil <br>
 * 描述: 二维码操作类 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月9日 上午11:41:22
 */
public class QRCodeUtil {
	public static BaseLog logger = new BaseLog();

	/**
	 * 根据内容，生成指定宽高、指定格式的二维码图片
	 *
	 * @param text
	 *            内容
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @param format
	 *            图片格式
	 * @return 生成的二维码图片路径
	 * @throws Exception
	 */
	public static String generateQRCode(String text, int width, int height, String path) throws Exception {
		Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
		File outputFile = new File(path);
		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}
		MatrixToImageWriter.writeToFile(bitMatrix, "png", outputFile);
		return path;
	}

	/**
	 * 解析指定路径下的二维码图片
	 *
	 * @param filePath
	 *            二维码图片路径
	 * @return
	 */
	public static String parseQRCode(String filePath) {
		String content = "";
		try {
			File file = new File(filePath);
			BufferedImage image = ImageIO.read(file);
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
			Map<DecodeHintType, Object> hints = new HashMap<>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
			MultiFormatReader formatReader = new MultiFormatReader();
			Result result = formatReader.decode(binaryBitmap, hints);
			logger.logInfo("result 为：" + result.toString());
			logger.logInfo("resultFormat 为：" + result.getBarcodeFormat());
			logger.logInfo("resultText 为：" + result.getText());
			// 设置返回值
			content = result.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}
}
