import be.tarsos.dsp.io.TarsosDSPAudioInputStream
import be.tarsos.dsp.io.PipedAudioStream

class CustomMFCC {
    /*
    * Fs:sample rate
    * x: data
    * */
    val Fs:Int? = null
    val x:Array<Float>?  = null

    fun mtFeatureExtraction(signal:Array<Float>, Fs:Int, stWin:Int, stStep:Int) {
    }

    fun stFeatureExtraction(signal:Array<Float>, Fs:Int, Win:Int, Step:Int) {
        val Win = Win.toInt()
        val Step = Step.toInt()

        // Signal normalization
        // in pyAudioAnalyst,signal = numpy.double(signal)
        var signalInternal = signal.map{ x -> x.toDouble()}
        signalInternal     = signalInternal / Math.pow(2.0,15.0)
    }


}
