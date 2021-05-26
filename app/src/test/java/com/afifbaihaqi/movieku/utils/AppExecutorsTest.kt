package com.afifbaihaqi.movieku.utils

import java.util.concurrent.Executor

class AppExecutorsTest: Executor {
    override fun execute(command: Runnable){
        command.run()
    }
}