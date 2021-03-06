package com.iwant.canvas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.omg.CORBA.Environment;

import com.iwant.canvas.interf.DownLoadListener;
import com.iwant.canvas.interf.Service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DownloadUtil {

	private static final String TAG = "DownloadUtil";
//    private static final String PATH_CHALLENGE_VIDEO = Environment.getExternalStorageDirectory() + "/DownloadFile";
    //视频下载相关
    protected Service mApi;
    private Call<ResponseBody> mCall;
//    private File mFile;
    private Thread mThread;
//    private String mVideoPath; //下载到本地的视频路径

    public DownloadUtil() {
        if (mApi == null) {
        //初始化网络请求接口
            mApi = ApiHelper.getInstance().buildRetrofit("http://192.168.3.19:8080/")
                    .createService(Service.class);
        }
    }

	public void downloadFile(String url, final DownLoadListener downloadListener) {
//        String name = url;
//        //通过Url得到文件并创建本地文件
//        if (FileUtils.createOrExistsDir(PATH_CHALLENGE_VIDEO)) {
//            int i = name.lastIndexOf('/');//一定是找最后一个'/'出现的位置
//            if (i != -1) {
//                name = name.substring(i);
//                mVideoPath = PATH_CHALLENGE_VIDEO +
//                        name;
//            }
//        }

//        建立一个文件
//        mFile = new File(mVideoPath);
        //!FileUtils.isFileExists(mFile) && FileUtils.createOrExistsFile(mFile)
//        if (1 != 1) {
//            if (mApi == null) {
//                Log.e(TAG, "downloadVideo: 下载接口为空了");
//                return;
//            }
            mCall = mApi.downloadFile(url);
            mCall.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
                    //下载文件放在子线程
                    mThread = new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            //保存到本地
//                            writeFile2Disk(response, mFile, downloadListener);
                            writeFile2Disk(response, downloadListener);
                        }
                    };
                    mThread.start();
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    downloadListener.onFailure(); //下载失败
                }
            });
//        } else {
//            downloadListener.onFinish(mVideoPath); //下载完成
//        }
    }
	//将下载的文件写入本地存储
//    Response<ResponseBody> response, File file, DownLoadListener downloadListener
    private void writeFile2Disk(Response<ResponseBody> response, DownLoadListener downloadListener) {
        downloadListener.onStart();
        long currentLength = 0;
//        OutputStream os = null;

        InputStream is = response.body().byteStream(); //获取下载输入流
        long totalLength = response.body().contentLength();
        try {
//            os = new FileOutputStream(file); //输出流
            int len;
            byte[] buff = new byte[1024];
            while ((len = is.read(buff)) != -1) {
//                os.write(buff, 0, len);
                currentLength += len;
                //计算当前下载百分比，并经由回调传出
                downloadListener.onProgress((int) (100 * currentLength / totalLength));
                //当百分比为100时下载结束，调用结束回调，并传出下载后的本地路径
                if ((int) (100 * currentLength / totalLength) == 100) {
                    downloadListener.onFinish(is); //下载完成
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            if (os != null) {
//                try {
//                    os.close(); //关闭输出流
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            if (is != null) {
                try {
                    is.close(); //关闭输入流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}