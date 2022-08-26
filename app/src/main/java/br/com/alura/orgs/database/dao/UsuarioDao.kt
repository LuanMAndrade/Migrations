package br.com.alura.orgs.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.alura.orgs.model.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {

    @Insert
    suspend fun insert(usuario: Usuario)

    @Query("SELECT * FROM Usuario WHERE id = :id AND senha = :senha")
    suspend fun autentica(id: String, senha: String): Usuario?

    @Query("SELECT * FROM Usuario WHERE id = :id")
    fun searchForId(id: String): Flow<Usuario>
}