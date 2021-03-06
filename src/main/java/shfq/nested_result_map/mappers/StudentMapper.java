/**
 *    Copyright 2009-2015 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package shfq.nested_result_map.mappers;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.IntegerTypeHandler;
import org.apache.ibatis.type.JdbcType;
import shfq.nested_result_map.vo.Student;

import java.util.Map;

/**
 * author:      shfq
 * description:
 * create date: 2016/5/11.
 */
public interface StudentMapper {
//    @SelectProvider(type = StudentMapper.class, method = "selectStudentMap")
    @Select("SELECT * FROM student WHERE id=#{id}")
    Student selectStudent(int id);
    @MapKey("id")
    @Select({"SELECT * FROM student WHERE id=#{id}"})
    Map<Integer, Student> selectStudentMap(int id);


    @ConstructorArgs(value = {
            @Arg(id = true, column = "id", javaType = int.class, jdbcType = JdbcType.INTEGER, typeHandler = IntegerTypeHandler.class),
            @Arg(column = "name"),
            @Arg(column = "branch"),
            @Arg(column = "percentage", javaType = int.class),
            @Arg(column = "phone", javaType = int.class),
            @Arg(column = "email"),
            @Arg(column = "address")})
    @Select("SELECT * FROM student WHERE id=#{id}")
    Student selectStudentWithConstructor(int id);
}
