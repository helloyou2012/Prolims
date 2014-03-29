package com.helloyou.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FilesZipper {
	/**
	 * 压缩文件列表中的文件
	 * @param basePath
	 * @param files
	 * @param zipFile
	 */
	public static boolean zipFiles(String basePath, List<String> files, String zipFile) {

		byte[] buffer = new byte[1024];

		try {

			FileOutputStream fos = new FileOutputStream(basePath + zipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);

			System.out.println("Output to Zip : " + basePath + zipFile);

			for (String file : files) {
				System.out.println("File Added : " + file);
				ZipEntry ze = new ZipEntry(file);
				zos.putNextEntry(ze);

				FileInputStream in = new FileInputStream(basePath + file);
				
				int len;
				while ((len = in.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}

				in.close();
			}

			zos.closeEntry();
			// remember close it
			zos.close();
			System.out.println("Done");
			return true;
		} catch (IOException ex) {
			return false;
		}
	}
}
