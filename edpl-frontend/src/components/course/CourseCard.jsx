import { Card, Typography } from 'antd';
const { Title, Paragraph } = Typography;

const CourseCard = function ({ title, description, image }) {
    return (
        <Card
            hoverable
            cover={<img alt="course" src={image} />}
            style={{
                backgroundColor: '#FFFFFF',
                border: '1px solid #E8E8E8',
                borderRadius: '4px',
                boxShadow: '0px 4px 12px rgba(0, 0, 0, 0.1)',
                width: '100%',
                maxWidth: '360px',
                margin: '0 auto',
                marginBottom: '24px'
            }}
        >
            <div style={{ padding: '16px'}}>
                <Title level={4} style={{ marginBottom: '8px'}}>{title}</Title>
                <Paragraph style={{ marginBottom: '16px' }}>{description}</Paragraph>
            </div>
        </Card>
    );
};
export default CourseCard;
