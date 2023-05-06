import React from 'react';
import { Card, Typography } from 'antd';

const { Meta } = Card;
const { Title } = Typography;

const TestCard = ({ test }) => {
    return (
        <Card hoverable cover={<img alt="example" src={test.image} />}>
            <Meta title={test.title} description={test.description} />
            <div style={{ marginTop: '16px' }}>
                <Title level={5}>Time: {test.time} minutes</Title>
            </div>
        </Card>
    );
};

export default TestCard;