import { useParams } from "react-router-dom";
import { useState, useLayoutEffect } from "react";
import { Layout } from "antd";
import CourseInfo from "../../components/course/CourseInfo";
import {api} from "../../api/courseController";

const { Content } = Layout;

const CoursePage = () => {
    const [course, setCourse] = useState({});
    const { id } = useParams();

    useLayoutEffect(() => {
        api.get(`/courses/${id}`)
        .then((result)=>{setCourse(result.data)})
        .catch(err=>console.log(err))

    }, [id]);

    return (
        <Layout>
            <Content>
                <div style={{ display: "flex", justifyContent: "center" }}>
                    <div style={{ maxWidth: "800px" }}>
                        <CourseInfo course={course} />
                    </div>
                </div>
            </Content>
        </Layout>
    );
};

export default CoursePage;