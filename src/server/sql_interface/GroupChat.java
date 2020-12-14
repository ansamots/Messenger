package server.sql_interface;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Интерфейс предназначен для выборки данных из таблицы group_chat базы test_db
 * Поля таблици следующие
 * 1. linc_id_user_in_groupcol (int) fk от таблицы user_in_group поле id_link (идентификатор отправителя в этой таблице)
 * 2. group_chatcol varchar(45) - поле в котором находятся сообщения
 * 3. data_message timestamp - дата когда сообщение записано в базу
 */
public interface GroupChat {
    /**
     * Метод возвращает сообщения
     * @param a - в массиве перечислены id всех отправителей которых нужно найти
     * @param timestamp - временная метка, указывает с какого отрезка времени нужно искать сообщения
     * @return Возвращаем массив стрингов (отправитель (int), сообщение (char), время(Timestamp))
     */
    public ArrayList<String> getMessage(int[] a, Timestamp timestamp);
}
