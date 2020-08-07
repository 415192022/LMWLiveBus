package com.lmw.livebus.bean

class User {
    var id: String? = null
    var name: String? = null

    fun set(id: String?) = id
    fun get(): String? {
        return id
    }
}