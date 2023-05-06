import { Card, Form, Input, Button, Row, Col } from 'antd';
import { useState } from 'react';

const LoginPage = () => {

    const onFinish = (values) => {
        localStorage.setItem('username', values.username);
        localStorage.setItem('password', values.password);


    };

    return (
        <Row justify="center" align="middle" style={{ height: '100vh' }}>
            <Col span={8}>

                <Card title="Вход">
                    <Form name="normal_login" initialValues={{ remember: true }} onFinish={onFinish}>
                        <Form.Item name="username" rules={[{ required: true, message: 'Пожалуйста, введите имя пользователя!' }]}>
                            <Input placeholder="Имя пользователя" />
                        </Form.Item>
                        <Form.Item name="password" rules={[{ required: true, message: 'Пожалуйста, введите пароль!' }]}>
                            <Input.Password placeholder="Пароль" />
                        </Form.Item>
                        <Form.Item>
                            <Button type="primary" htmlType="submit">
                                Войти
                            </Button>
                        </Form.Item>
                    </Form>

                </Card>
            </Col>
        </Row>
    );
};

export default LoginPage;