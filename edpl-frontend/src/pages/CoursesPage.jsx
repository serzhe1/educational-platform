
import { Input, Layout } from 'antd';
import { Link } from 'react-router-dom';
import { useLayoutEffect, useState } from 'react';
import CourseCard from '../components/course/CourseCard';
import {api} from '../api/courseController';


const { Content, Footer } = Layout;
const staticImage = "https://findstack.com/wp-content/uploads/2021/06/How-to-Create-an-Online-Course.png"

const CoursesPage = () => {
    const [searchTerm, setSearchTerm] = useState("");
    const [coursesList,setCoursesList] = useState([]);

    useLayoutEffect(()=>{
       api.get()
       .then((result)=>{setCoursesList(result.data)})
       .catch(err=>console.log(err))
    },[])

    useLayoutEffect(()=>{
        api.get(`/courses?namePattern=${searchTerm}`)
        .then((result)=>{setCoursesList(result.data)})
        .catch(err=>console.log(err))
    },[searchTerm])
   


    const handleSearch = (event) => {
        setSearchTerm(event.target.value);
    };
    return  (
        
        <Layout>
            <Content style={{ padding: '50px' }}>
                <div style={{ marginBottom: "20px" }}>
                    <Input.Search
                        placeholder="Поиск по курсам"
                        defaultValue={searchTerm}
                        onPressEnter={handleSearch}
                    />
                </div>
                <div style={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'space-between' }}>
                    {
                    coursesList.map(course => (
                        <Link key={course.id} to={`/courses/${course.id}`}>
                            <CourseCard title={course.name} description={course.description} image={staticImage} />
                        </Link>
                    ))}
                </div>
            </Content>
            <Footer style={{ textAlign: 'center' }}>MyApp ©2023 Created by Me</Footer>
        </Layout>
    );
};

export default CoursesPage;