import { Layout, Avatar, List, Button } from 'antd';
import { useLayoutEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import {api, token} from '../api/courseController';

const { Content } = Layout;

const courses = [
    { id: 1, title: 'Курс 1' },
    { id: 2, title: 'Курс 2' },
    { id: 3, title: 'Курс 3' },
];

const user = {
    avatar: "data:image/jpeg;base64,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",
    firstName: "Giga",
    lastName: "Chad",
    email: "giga_chad@email.com"
}

const StudentProfile = () => {
    const handleUnsubscribe = (id) => {
        // Здесь должна быть логика отписки пользователя от курса по id
        console.log(`User unsubscribed from course with id ${id}`);
    };

    const [user, setUser] = useState({});

    useLayoutEffect(() => {
        api.get(`/users/me`, {
            headers: {
                'Authorization': `Basic ${token}`
              },
        })
            .then((result) => { setUser(result.data) })
            .catch(err => console.log(err))

    }, []);

    return (
        <Layout>
            <Content style={{ padding: '50px' }}>
                <div style={{ display: 'flex', alignItems: 'center', marginBottom: '30px' }}>
                    <Avatar size={64} src={user.avatar} style={{ marginRight: '20px' }} />
                    <div>
                        <h2>{user.firstName} {user.lastName}</h2>
                        <p>{user.email}</p>
                    </div>
                </div>
                <h3>Мои курсы</h3>
                <List
                    bordered
                    dataSource={courses}
                    renderItem={(course) => (
                        <List.Item>
                            <div style={{ display: 'flex', justifyContent: 'space-between', width: '100%' }}>
                                <Link to={"/courses/1"}> <span>{course.title}</span> </Link>
                                <Button onClick={() => handleUnsubscribe(course.id)}>Отписаться</Button>
                            </div>
                        </List.Item>
                    )}
                />
            </Content>
        </Layout>
    );
};

export default StudentProfile;