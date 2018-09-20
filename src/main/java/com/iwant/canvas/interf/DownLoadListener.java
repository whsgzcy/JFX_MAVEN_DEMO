package com.iwant.canvas.interf;

import java.io.InputStream;

public interface DownLoadListener {

	void onStart();

	void onProgress(int currentLength);

	// void onFinish(String localPath);
	void onFinish(InputStream is);

	void onFailure();

}