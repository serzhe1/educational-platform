import React from 'react';
import { Layout, Typography, Row, Col, Collapse } from 'antd';
import LectureList from './LectureList';
const { Content } = Layout;
const { Title, Paragraph } = Typography;
const { Panel } = Collapse;

const CourseInfo = ({ course }) => {
    return (
        <Content>
            <Row gutter={[32, 32]}>
                <Col span={16}>
                    <Title level={1}>{course.name}</Title>
                    <Paragraph>{course.description}</Paragraph>
                    <Title level={2}>Формат курса</Title>
                    <Paragraph>{course.format}</Paragraph>
                    <Title level={2}>Требования к участникам</Title>
                    <Paragraph>{course.requirements}</Paragraph>
                    <Title level={2}>Компетенции</Title>
                    <Paragraph>{course.competencies}</Paragraph>
                    <Title level={2}>Модули</Title>
                    {course.modules !== undefined &&
                        <Collapse>
                            {course.modules.map((module) => (
                                <Panel key={module.id} header={module.name}>
                                    <div key={course.id}>
                                        <LectureList lectures={module.lectures} />
                                    </div>
                                </Panel>
                            ))}
                        </Collapse>
                    }
                </Col>
            </Row>
        </Content>
    );
};

export default CourseInfo;