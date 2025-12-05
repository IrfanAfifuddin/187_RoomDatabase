package com.example.a187_roomdatabase.repositori

import com.example.a187_roomdatabase.room.Siswa
import com.example.a187_roomdatabase.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun InsertSiswa(siswa: Siswa)
    fun getSiswaStream(id: Int): Flow<Siswa?>
    suspend fun updateSiswa(siswa: Siswa)
    suspend fun deleteSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa(
    private val siswaDao: SiswaDao
): RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override suspend fun InsertSiswa(siswa: Siswa) = siswaDao.insert(siswa)

    override fun getSiswaStream(id: Int): Flow<Siswa?> = siswaDao.getSiswa(id)
    override suspend fun updateSiswa(siswa: Siswa) = siswaDao.update(siswa)
    override suspend fun deleteSiswa(siswa: Siswa) = siswaDao.delete(siswa)
}