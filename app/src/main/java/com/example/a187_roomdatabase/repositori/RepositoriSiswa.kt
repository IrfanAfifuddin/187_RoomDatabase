package com.example.a187_roomdatabase.repositori

import com.example.a187_roomdatabase.room.Siswa
import com.example.a187_roomdatabase.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswa(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa(
    private val siswaDao: SiswaDao
): RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override suspend fun InsertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
}