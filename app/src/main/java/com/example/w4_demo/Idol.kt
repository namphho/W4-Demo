package com.example.w4_demo

/**
 * Created by nampham on 4/16/21.
 */
class Idol(val id: Int, val name: String, val job: String, val avatar: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Idol

        if (id != other.id) return false
        if (name != other.name) return false
        if (job != other.job) return false
        if (avatar != other.avatar) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + job.hashCode()
        result = 31 * result + avatar
        return result
    }


}