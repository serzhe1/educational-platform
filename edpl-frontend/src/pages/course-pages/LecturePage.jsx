import React from 'react';
import { Layout, Typography, Row, Col } from 'antd';
import LectureContent from '../../components/course/LectureContent';
const { Content } = Layout;
const { Title } = Typography;



const LecturePage = () => {
    const name = "Configuration"

    return (
        <Layout>
            <Content>
                <div style={{ display: "flex", justifyContent: "center" }}>
                    <div style={{ maxWidth: "800px" }}>
                        <Content>
                            <Row>
                                <Col span={40}>
                                    <Title level={1}>{name}</Title>
                                    <LectureContent  />
                                </Col>
                            </Row>
                        </Content>
                    </div>
                </div>
            </Content>
        </Layout>
    );
};

export default LecturePage;