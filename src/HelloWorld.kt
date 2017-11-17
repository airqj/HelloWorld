import be.tarsos.dsp.AudioDispatcher
import be.tarsos.dsp.AudioEvent
import be.tarsos.dsp.AudioProcessor
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory
import be.tarsos.dsp.mfcc.MFCC
import java.io.File
import java.util.Arrays

import javax.sound.sampled.UnsupportedAudioFileException
import javax.sound.sampled.spi.AudioFileReader

class MFCCTest {

    //	private static int counter = 0;
    fun CacularMFCC(fileName: String) {
        val sampleRate = 44100
        val bufferSize = 2205
        val bufferOverlap = 1102
        val file = File(fileName + "_tarsos.csv")
        //val dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(sampleRate,bufferSize,bufferOverlap)
        val dispatcher = AudioDispatcherFactory.fromFile(File(fileName),bufferSize,bufferOverlap)
        //val mfcc = MFCC(bufferSize,sampleRate)
        val mfcc = MFCC(bufferSize, sampleRate.toFloat(), 39, 40, 133.3334f, sampleRate.toFloat() / 2f);
        dispatcher.addAudioProcessor(mfcc)
        dispatcher.addAudioProcessor(object : AudioProcessor {
            override fun processingFinished() {
            }
            override fun process(audioEvent: AudioEvent): Boolean {
                //println(Arrays.toString(mfcc?.mfcc))
                file.appendText(Arrays.toString(mfcc?.mfcc))
                file.appendText("\n")
                return true
            }
        })
        Thread(dispatcher, "Audio Dispatcher").start()
    }
}

class HelloWorld {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            MFCCTest().CacularMFCC(args[0])
            println("Kotlin main is running here!")
        }
    }
}