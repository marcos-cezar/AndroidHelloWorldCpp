#include <jni.h>

extern "C" {

    char msg[] = "greetings from C/C++";

    JNICALL JNIEXPORT jstring
    Java_br_com_razecapps_samplewithbutton_MainActivity_sayHello(JNIEnv *env,
                                                                 jobject thiz) {
        return env->NewStringUTF(msg);
    }

}
