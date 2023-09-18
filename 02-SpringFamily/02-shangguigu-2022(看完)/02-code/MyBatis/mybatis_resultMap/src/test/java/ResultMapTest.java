import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Author liming
 * @Date 2022/12/21 11:04
 **/
public class ResultMapTest {
    @Test
    public void testGetEmpByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpByEmpId(2);
        System.out.println(emp);
        //Emp{empId=null, empName='null', age=20, gender='男'}
    }

    @Test
    public void testGetEmpAndDeptByEmpId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByEmpId(2);
        System.out.println(emp);
        //Emp{empId=1, empName='张三', age=20, gender='男', dept=Dept{deptId=1, deptName='A'}}
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(1);
        //System.out.println(emp);
        //Emp{empId=1, empName='张三', age=20, gender='男', dept=Dept{deptId=1, deptName='A'}}
        System.out.println(emp.getEmpName());  //张三
    }

    @Test
    public void testGetDeptAndEmpByDeptId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByDeptId(1);
        System.out.println(dept);
        //Dept{deptId=1, deptName='A', emps=[Emp{empId=1, empName='张三', age=20, gender='男', dept=null}, Emp{empId=4, empName='赵六', age=24, gender='男', dept=null}]}
    }

    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept);
        //Dept{deptId=1, deptName='A', emps=[Emp{empId=1, empName='张三', age=20, gender='男', dept=null}, Emp{empId=4, empName='赵六', age=24, gender='男', dept=null}]}
    }
}
