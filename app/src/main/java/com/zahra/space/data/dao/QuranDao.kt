package com.zahra.space.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.zahra.space.data.entity.QuranAyat
import kotlinx.coroutines.flow.Flow

@Dao
interface QuranDao {
    @Query("SELECT * FROM quran_ayat WHERE surahId = :surahId ORDER BY ayatNumber")
    fun getAyatBySurah(surahId: Int): Flow<List<QuranAyat>>
    
    @Query("SELECT * FROM quran_ayat WHERE surahId = :surahId AND ayatNumber = :ayatNumber")
    fun getAyat(surahId: Int, ayatNumber: Int): Flow<QuranAyat?>
    
    @Query("""
        SELECT DISTINCT 
            surahId, surahName, surahNameLatin, juz,
            0 as id,
            0 as ayatNumber,
            '' as arabicText,
            '' as latinText,
            '' as translationId
        FROM quran_ayat
        GROUP BY surahId
        ORDER BY surahId
    """)
    fun getSurahList(): Flow<List<QuranAyat>>
}
