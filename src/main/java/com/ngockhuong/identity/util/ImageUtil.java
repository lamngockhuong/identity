package com.ngockhuong.identity.util;

import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtil {
    public static BufferedImage crop(BufferedImage image, int width, int height) {
        Image tmp = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        return resized;
    }

    public static BufferedImage crop(byte[] image, int width, int height) throws IOException {
        InputStream in = new ByteArrayInputStream(image);
        BufferedImage originalImage = ImageIO.read(in);
        Image tmp = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return resized;
    }

    public static BufferedImage crop(File imageFile, int width, int height) throws IOException {
        BufferedImage image = ImageIO.read(imageFile);
        Image tmp = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        return resized;
    }

    public static boolean write(BufferedImage image, String extension, File fileOutputPath) throws IOException {
        return ImageIO.write(image, extension, fileOutputPath);
    }

    public static String generateThumbnail(File imageFile, String imageName, String outputPath, int width, int height) throws IOException {
        BufferedImage image = crop(imageFile, width, height);
        String name = FilenameUtils.getBaseName(imageName);
        String extension = FilenameUtils.getExtension(imageName);
        String thumbnailName = name + "-" + width + "x" + height + "." + extension;
        File fileOutputPath = new File(outputPath + File.separator + thumbnailName);

        if (write(image, extension, fileOutputPath)) {
            return thumbnailName;
        } else {
            return "";
        }
    }

    public static String generateThumbnail(byte[] image, String imageName, String outputPath, int width, int height) throws IOException {
        BufferedImage bufferedImage = crop(image, width, height);
        String name = FilenameUtils.getBaseName(imageName);
        String extension = FilenameUtils.getExtension(imageName);
        String thumbnailName = name + "-" + width + "x" + height + "." + extension;
        File fileOutputPath = new File(outputPath + File.separator + thumbnailName);

        if (write(bufferedImage, extension, fileOutputPath)) {
            return thumbnailName;
        } else {
            return "";
        }
    }
}
